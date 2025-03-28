package in.scaler.bookmyshow;

import in.scaler.bookmyshow.controllers.UserController;
import in.scaler.bookmyshow.dtos.*;
import in.scaler.bookmyshow.dtos.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BookMyShowMay24ApplicationTests {
    @Autowired
    private UserController userController;

    @Test
    void contextLoads() {
    }

    @Test
    public void testSignUpFunctionality() {
        SignupRequestDto requestDto = new SignupRequestDto();
        requestDto.setName("abhi");
        requestDto.setEmail("abhi@email.com");
        requestDto.setPassword("123456");

        SignupResponseDto responseDto = userController.signUp(
                requestDto
        );

        System.out.println(responseDto.getUserId());
    }

    @Test
    public void testLoginFunctionality() {
        LoginRequestDto requestDto = new LoginRequestDto();
        requestDto.setEmail("Max@email.com");
        requestDto.setPassword("abcD");

        LoginResponseDto responseDto = userController.login(requestDto);

        if (responseDto.getResponseStatus().equals(ResponseStatus.SUCCESS)) {
            System.out.println("Login Successful");
        } else {
            System.out.println("Login Unsuccessful");
        }
    }
}
