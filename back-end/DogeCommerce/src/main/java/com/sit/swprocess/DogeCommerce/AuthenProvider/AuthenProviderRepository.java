package com.sit.swprocess.DogeCommerce.AuthenProvider;

import org.springframework.data.jpa.repository.JpaRepository;

interface AuthenProviderRepository extends JpaRepository<AuthenProvider, Long> {
    public AuthenProvider getByToken(String token);
}
