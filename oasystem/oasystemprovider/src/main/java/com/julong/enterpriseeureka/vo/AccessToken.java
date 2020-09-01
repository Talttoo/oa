package com.julong.enterpriseeureka.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class AccessToken {


    /**
     * errcode : 0
     * errmsg : ok
     * access_token : -_dMNZ1GSy-5D7VlZ9LIKQNWLRoETe9cWButaL_WoFZKhVvisNSSHVmJkCuc_jDGmulr6NwyJRqLVeXDUpS3EbG5ruzWggtm-a6HAsfKEUCoHoGQl6zcsf9Q6L44jOZX7KT8Q9lEkdsKYrC8NRGow7CYKuDu99YM1N2QB9gBcw4q8VikbqgGSZfuEv0wg_9nUOD04Y6dEux1cyvCwnPliA
     * expires_in : 7200
     */

    private int errcode;
    private String errmsg;
    private String access_token;
    private int expires_in;
}
