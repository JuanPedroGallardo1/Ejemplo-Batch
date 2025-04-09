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
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) {
        System.out.println("Mostrando información de usuarios");
        List<UserEntity> usuarios = (List<UserEntity>) chunkContext.getStepContext().getJobExecutionContext().get("users");

        usuarios.forEach(user -> System.out.println(user.toString()));

        System.out.println("Fin de la información de usuarios");

        return RepeatStatus.FINISHED;
    }
}
