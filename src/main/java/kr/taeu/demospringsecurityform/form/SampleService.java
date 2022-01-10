package kr.taeu.demospringsecurityform.form;

import kr.taeu.demospringsecurityform.account.Account;
import kr.taeu.demospringsecurityform.account.AccountContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class SampleService {

    public void dashboard() {
        // Principal과 GrantAuthority 제공 - SecurityContextHolder에는 인증이 된 정보만 들어간다.
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // 인증을 한 사용자 정보
        Object principal = authentication.getPrincipal();
        // 인증을 한 사용자의 권한들
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        // 인증을 위한 정보(대개는 패스워드)
        Object credentials = authentication.getCredentials();
        // 인증을 한 사용자인지
        boolean authenticated = authentication.isAuthenticated();
    }

    public void dashboard2() {
        Account account = AccountContext.getAccount();
        System.out.println("=======================");
        System.out.println("account = " + account.getUsername());
    }
}
