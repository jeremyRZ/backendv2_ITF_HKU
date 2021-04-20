package itf.hku.backend.service.impl;

import itf.hku.backend.entity.Task;
import itf.hku.backend.mapper.TaskMapper;
import itf.hku.backend.service.TaskService;
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
public class TaskServiceImpl extends ServiceImpl<TaskMapper, Task> implements TaskService {

}
