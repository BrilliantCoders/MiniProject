package com.database;
import java.util.Collection;
import java.util.List;

import com.helper.GlobalVariables;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class AppUserDetailsServiceDAO implements UserDetailsService {


    protected final Log logger = LogFactory.getLog(getClass());

    public UserDetails loadUserByUsername(final String username)
            throws UsernameNotFoundException {

        logger.info("loadUserByUsername username="+username);

        if(!username.equals("pankaj")){
            throw new UsernameNotFoundException(username + " not found");
        }

        //creating dummy user details, should do JDBC operations
        return new UserDetails() {

            private static final long serialVersionUID = 2059202961588104658L;


            public boolean isEnabled() {
                return true;
            }


            public boolean isCredentialsNonExpired() {
                return true;
            }


            public boolean isAccountNonLocked() {
                return true;
            }


            public boolean isAccountNonExpired() {
                return true;
            }


            public String getUsername() {
                return username;
            }


            public String getPassword() {
                return "pankaj123";
            }


            public Collection<? extends GrantedAuthority> getAuthorities() {
                List<SimpleGrantedAuthority> auths = new java.util.ArrayList<SimpleGrantedAuthority>();
                auths.add(new SimpleGrantedAuthority("admin"));
                return auths;
            }
        };
    }

}