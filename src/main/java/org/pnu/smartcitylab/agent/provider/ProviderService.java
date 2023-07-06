package org.pnu.smartcitylab.agent.provider;

import lombok.AllArgsConstructor;
import org.pnu.smartcitylab.agent.provider.dto.CreateProviderDTO;
import org.pnu.smartcitylab.agent.entity.ProviderEntity;
import org.pnu.smartcitylab.agent.provider.dto.UpdateProviderDTO;
import org.pnu.smartcitylab.agent.repository.ProviderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@Service
public class ProviderService {
    private ProviderRepository providerRepository;

    public ProviderEntity createProvider(CreateProviderDTO dto) {
        String id = UUID.randomUUID().toString();
        dto.setId(id);
        ProviderEntity item = new ProviderEntity(dto.getId(), dto.getProvider_nm(), dto.getProvider_login_id(), dto.getProvider_login_pw());
        return providerRepository.save(item);
    }

    public List<ProviderEntity> getProviderList() {
        return providerRepository.findAll();
    }

    public Optional<ProviderEntity> getProvider(String id) {
        return providerRepository.findById(id);
    }

    public ProviderEntity updateProvider(UpdateProviderDTO dto) throws Exception {
        Optional<ProviderEntity> check = providerRepository.findById(dto.getId());
        System.out.println(check);
        if (check.isEmpty()) {
            throw new Exception("회원 정보가 없습니다.");
        }
        ProviderEntity item = new ProviderEntity(dto.getId(), dto.getProvider_nm(), dto.getProvider_login_pw());
        return providerRepository.save(item);
    }

    public String deleteProvider(String id) throws Exception {
        Optional<ProviderEntity> check = providerRepository.findById(id);
        if (check.isEmpty()) {
            throw new Exception("회원 정보가 없습니다.");
        }
        providerRepository.deleteById(id);
        return id;
    }
}
