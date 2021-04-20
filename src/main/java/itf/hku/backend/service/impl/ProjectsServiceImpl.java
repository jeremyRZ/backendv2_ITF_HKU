package itf.hku.backend.service.impl;

import itf.hku.backend.entity.Projects;
import itf.hku.backend.mapper.ProjectsMapper;
import itf.hku.backend.service.ProjectsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author JeremyZhao
 * @since 2021-04-20
 */
@Service
public class ProjectsServiceImpl extends ServiceImpl<ProjectsMapper, Projects> implements ProjectsService {

}
