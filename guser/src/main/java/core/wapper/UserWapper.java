package core.wapper;

import domain.User;

/**
 * Created by jetluo on 16/6/23.
 */
public final class UserWapper {
    private final User pojo;

    private UserWapper(User toWrap){
        this.pojo = toWrap;
    }

    public static UserWapper wrap(User toWrap){
        if(toWrap != null){
            return new UserWapper(toWrap);
        }
        return null;
    }



}
