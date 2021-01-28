package com.example.springtest.serviceLayer;

import com.example.springtest.dao.entity.User;
import com.example.springtest.dao.repository.UserRepository;
import com.example.springtest.service.GreetingService;
import com.example.springtest.service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;
    @Mock
    private GreetingService greetingService;

    @InjectMocks
    private UserServiceImpl userServiceImpl;

    @Test
    public void whenUserIsNull() {
        //テスト用データを準備
        String userName = "notFound";
        given(userRepository.findUserByName(userName)).willReturn(null);
        //given(greetingService.createTempPassword(userName)).willReturn("Hello notFound");

        //テストを実施
        User result = userServiceImpl.getUserByUserName(userName);

        //テスト結果と想定結果の比較
        assertThat(result).isNotNull();
        assertThat(result.getName()).isEqualTo("Guest");
        assertThat(result.getPassword()).isNull();
        assertThat(result.getUserId()).isNull();
    }

}
