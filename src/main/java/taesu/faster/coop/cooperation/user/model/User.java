package taesu.faster.coop.cooperation.user.model;

import com.nimbusds.jwt.JWTClaimsSet;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import taesu.faster.coop.cooperation.token.model.TokenSource;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Objects;

/**
 * @author Lee Tae Su
 * @version 1.0
 * @project cooperation
 * @since 2018-01-22
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="USER")
public final class User implements Serializable, TokenSource<UserTokenType> {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USER_KEY")
    private Long userKey;
	
	@Column(name = "USER_ID")
    private String userId;
	
	@Column(name = "PASSWORD")
    private String password;
	
	@Column(name="GENDER")
    private Integer gender;
	
	@Column(name="EMAIL")
    private String email;
	
	@Column(name = "PHONE")
    private String phone;
	
	@Column(name="PROFILE_FILE_KEY")
    private Long profileFileKey;
	
	@Column(name = "ROLE_KEY")
    private Long roleKey;
	
	@Column(name = "USER_NAME")
    private String userName;
	
	@Column(name = "IS_ACCOUNT_NON_EXPIRED")
    private Boolean isAccountNonExpired;
	
	@Column(name = "IS_ACCOUNT_NON_LOCKED")
    private Boolean isAccountNonLocked;
	
	@Column(name = "IS_CREDENTIALS_NON_EXPIRED")
    private Boolean isCredentialsNonExpired;
	
	@Column(name = "IS_ENABLED")
    private Boolean isEnabled;
	
	@Column(name = "BIRTH")
    private String birth;
	
	@Column(name = "CITY_TYPE_KEY")
    private Integer cityTypeKey;
	
	@Column(name = "CREATED_AT")
    private ZonedDateTime createdAt;
	
    @Override
    public JWTClaimsSet.Builder getClaimedBuilder(UserTokenType userTokenType) {
        if(Objects.equals(userTokenType, UserTokenType.ACCESS_TOKEN)) {
            return new JWTClaimsSet.Builder()
                    .claim("userId", getUserId())
                    .claim("userKey", getUserKey());
        } else if(Objects.equals(userTokenType, UserTokenType.ENCRYPT_TOKEN)) {
            return new JWTClaimsSet.Builder()
                    .claim("userId", getUserId())
                    .claim("userKey", getUserKey());
        } else {
            throw new RuntimeException("This token Type [" + userTokenType + "] is not supported");
        }
    }

    /**
     * JWTClaimSet 이 담고있는 payload 를 기반으로 사용자 인스턴스를 생성한다
     * 반드시 getClaimedBuilder 에 대응하는 필드를 기반으로 User 인스턴스를 변환해야 한다
     *
     * @param jwtClaimsSet  복호화 된 SignedJWT 로 부터 생성 된 ClaimSet
     * @param userTokenType 복호화 할 사용자 토큰 타입
     * @return 변환 완료 된 User 인스턴스
     */
    public static User getConvertedSource(JWTClaimsSet jwtClaimsSet, UserTokenType userTokenType) {
        User user = new User();

        if(Objects.equals(userTokenType, UserTokenType.ACCESS_TOKEN)) {
            user.setUserKey((Long) jwtClaimsSet.getClaim("userKey"));
            user.setUserId((String) jwtClaimsSet.getClaim("userId"));
            return user;
        } else if(Objects.equals(userTokenType, UserTokenType.ENCRYPT_TOKEN)) {
            user.setUserKey((Long) jwtClaimsSet.getClaim("userKey"));
            user.setUserId((String) jwtClaimsSet.getClaim("userId"));
            return user;
        } else {
            throw new RuntimeException("This token Type [" + userTokenType + "] is not supported");
        }
    }
}
