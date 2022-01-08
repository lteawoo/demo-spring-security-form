package kr.taeu.demospringsecurityform.account;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @Autowired
    AccountService accountService;

    /*
    실무에선 이렇게 절대 쓰면 안된다.
    샘플 용도로만 사용
     */
    @GetMapping("/account/{role}/{username}/{password}")
    public Account createAccount(@ModelAttribute Account account) {
        return accountService.createNew(account);
    }
}
