package org.koreait.controllers.users;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.koreait.entities.Users;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

@Data @Builder
@NoArgsConstructor @AllArgsConstructor //기본 생성자
public class JoinForm {

    @NotBlank
    @Size(min = 6)
    private String userId;

    @NotBlank
    @Size(min = 8, max = 16)
    private String userPw;

    @NotBlank
    private String userPwRe;

    @NotBlank
    private String userNm;

    @Email
    private String email;

    private String mobile;

    @AssertTrue // 필수
    private boolean agree;

    public static Users of(JoinForm joinForm){
        ModelMapper mapper = new ModelMapper();
        Users user = mapper.map(joinForm, Users.class);

        return user;
    }

}
