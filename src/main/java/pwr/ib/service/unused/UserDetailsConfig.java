//package pwr.ib.service;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//
//public class UserDetailsConfig  implements UserDetails {
//    private UserDto userDto;
//
//    public UserDetailsConfig(UserDto userDto) {
//        this.userDto = userDto;
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//
//        List<GrantedAuthority> authorities = new ArrayList<>();
//        GrantedAuthority authority = new SimpleGrantedAuthority(this.userDto.getRole());
//        authorities.add(authority);
//        return authorities;
//    }
//
//    @Override
//    public String getPassword() {
//        return userDto.getPasswordHash();
//    }
//
//    @Override
//    public String getUsername() {
//        return userDto.getName();
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//}
