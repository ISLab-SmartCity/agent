db = db.getSiblingDB('smartcity');  // 데이터베이스 이름

db.createUser({
  user: 'islab',
  pwd: 'islab',  // 패스워드 설정
  roles: [
    {
      role: 'readWrite',
      db: 'smartcity'
    }
  ]
});

