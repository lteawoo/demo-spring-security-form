package kr.taeu.demospringsecurityform.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * SecurityConfig에
 * protected void configure(AuthenticationManagerBuilder auth) throws Exception {
 * auth.userDetailsService(accountService);
 * 로 등록 해도 되지만 UserDetailsService의 구현체가 bean으로 등록되어 있어도 사용가능함
 */
@Service
public class AccountService implements UserDetailsService {

    // TODO {noop}123 같은 형식으로 패스워드를 맞춰야함
    @Autowired
    AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findByUsername(username);
        if (account == null) {
            throw new UsernameNotFoundException(username);
        }

        return User.builder()
                .username(account.getUsername())
                .password(account.getPassword())
                .roles(account.getRole())
                .build();
    }

    public Account createNew(Account account) {
        account.encodePassword();
        return accountRepository.save(account);
    }
}
