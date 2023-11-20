package com.green.greengram2.user;

import com.green.greengram2.ResVo;
import com.green.greengram2.user.model.UserSigninDto;
import com.green.greengram2.user.model.UserSigninVo;
import com.green.greengram2.user.model.UserSignupDto;
import com.green.greengram2.user.model.UserSignupProcDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper mapper;

    public UserSigninVo userSignin(UserSigninDto dto) {
        String savedPw = ""; //DB에서 가져온 비밀번호
        boolean comparedPw = BCrypt.checkpw(dto.getUpw(), savedPw);
    }

    public ResVo userSignup(UserSignupDto dto) {
        String hashedPw = BCrypt.hashpw(dto.getUpw(), BCrypt.gensalt());
        log.info("hashedPw : {}", hashedPw);
        UserSignupProcDto pDto = UserSignupProcDto.builder()
                .uid(dto.getUid())
                .upw(hashedPw)
                .nm(dto.getNm())
                .pic(dto.getPic())
                .build();
        int affectedRows = mapper.insUser(pDto);
        if(affectedRows == 0) {
            return new ResVo(0);
        }
        return new ResVo(pDto.getIuser());
    }
}
