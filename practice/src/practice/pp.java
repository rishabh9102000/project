package practice;

import java.util.ArrayList;
import java.util.List;

public class pp {
	public static void main(String [] args) {
		List<Integer> l = new ArrayList<Integer>();
		l.add(1);
		l.add(2);
		System.out.println(l.indexOf(2));
	}
//	 @Bean
//    public InMemoryUserDetailsManager userDetailsService() {
//        UserDetails user1 = User.withUsername("user1")
//            .password(passwordEncoder().encode("user1Pass"))
//            .roles("USER")
//            .build();
//        UserDetails user2 = User.withUsername("user2")
//            .password(passwordEncoder().encode("user2Pass"))
//            .roles("USER")
//            .build();
//        UserDetails admin = User.withUsername("admin")
//            .password(passwordEncoder().encode("adminPass"))
//            .roles("ADMIN")
//            .build();
//        return new InMemoryUserDetailsManager(user1, user2, admin);
//    }
//    @Bean
//    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
//        // Configure AuthenticationManagerBuilder
//        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
//        authenticationManagerBuilder.userDetailsService(service).passwordEncoder(passwordEncoder());
//        // Get AuthenticationManager
//        AuthenticationManager authenticationManager = authenticationManagerBuilder.build();
//        http
//        .csrf((csrf) -> csrf.disable())
//
//        .authorizeHttpRequests(authorize -> authorize
//                .requestMatchers("city/**").hasRole("ADMIN").anyRequest().authenticated()
//                )
////        .securityMatchers((matchers) -> matchers
////                .requestMatchers("/city/**")
////               
////            );
//        .formLogin(formLogin -> formLogin
////                .loginPage("/login")
//        		.permitAll()
//        );
//  
//        return http.build();
//    }
}
