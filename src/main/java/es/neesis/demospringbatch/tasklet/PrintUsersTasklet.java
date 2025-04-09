package es.neesis.demospringbatch.tasklet;


import es.neesis.demospringbatch.model.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
@RequiredArgsConstructor
public class PrintUsersTasklet implements Tasklet {

    private final DataSource dataSource;

    @Override
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        List<UserEntity> users = jdbcTemplate.query(
                "SELECT * FROM users",
                new BeanPropertyRowMapper<>(UserEntity.class)
        );

        users.forEach(System.out::println); // Imprime cada usuario en consola

        return RepeatStatus.FINISHED;
    }
}
