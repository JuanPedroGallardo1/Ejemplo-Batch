package es.neesis.demospringbatch.model;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Builder
@Data
public class UserEntity {
    private Integer id;
    private String username;
    private String password;
    private String email;
    private String fullname;
    private Timestamp creadoEn;
}
