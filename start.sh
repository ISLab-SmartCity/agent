IMAGE="smartcitylab-agent"
TAG=$(date +%y%m%d-%H%M%S)
export IMAGE TAG

echo "smartcitylab-agent: Deploying..."

echo "smartcitylab-agent: Buillding Docker Image..."

# Build the project
# docker build -t ${IMAGE}:${TAG} .
docker compose build

if [ $? -ne 0 ]; then
    echo "smartcitylab-agent: Docker Image Build Failed"
    exit 1
fi

# nuri 네트워크 존재 여부 확인
if ! docker network ls | grep -q "smartcity"; then
    echo "smartcity:  네트워크가 없습니다. 새로 생성합니다."
    docker network create smartcity
else
    echo "smartcity 네트워크가 이미 존재합니다."
fi


echo "smartcitylab-agent: Docker Image Built Successfully: ${IMAGE}:${TAG}"

echo "smartcitylab-agent: Running Docker Container..."

if [ $(docker ps -q -f name=smartcitylab-agent-container) ]; then
    echo "smartcitylab-agent: 이미 존재하는 컨테이너가 있습니다. 컨테이너를 중지하고 재시작합니다."
    docker compose restart
else
    docker compose up -d
fi

if [ $? -ne 0 ]; then
    echo "smartcitylab-agent: Docker Container Run Failed"
    exit 1
fi

echo "smartcitylab-agent: Docker Container Running Successfully"
