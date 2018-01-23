package taesu.faster.coop.cooperation.token.service;

import taesu.faster.coop.cooperation.token.model.Token;

/**
 * @author Lee Tae Su
 * @version 1.0
 * @project cooperation
 * @since 2018-01-23
 */
public interface TokenService {
    Token addToken(Token token);

    Token getToken();
}
