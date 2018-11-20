package com.sit.swprocess.DogeCommerce.AuthenProvider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenProviderService {

    @Autowired
    AuthenProviderRepository authenProviderRepository;

    public AuthenProvider getAuthenProviderById(Long authenProviderId) {
        return authenProviderRepository.getOne(authenProviderId);
    }

    public AuthenProvider getAuthenProviderByToken(String token) {
        return authenProviderRepository.getByToken(token);
    }
}
