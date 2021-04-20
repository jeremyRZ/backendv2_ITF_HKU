package itf.hku.backend.service.impl;

import itf.hku.backend.entity.Logs;
import itf.hku.backend.mapper.LogsMapper;
import itf.hku.backend.service.LogsService;
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
public class LogsServiceImpl extends ServiceImpl<LogsMapper, Logs> implements LogsService {

}
