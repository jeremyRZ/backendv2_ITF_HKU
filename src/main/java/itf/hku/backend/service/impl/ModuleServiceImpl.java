package itf.hku.backend.service.impl;

import itf.hku.backend.entity.Module;
import itf.hku.backend.mapper.ModuleMapper;
import itf.hku.backend.service.ModuleService;
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
public class ModuleServiceImpl extends ServiceImpl<ModuleMapper, Module> implements ModuleService {

}
