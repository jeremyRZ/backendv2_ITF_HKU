package itf.hku.backend.service.impl;

import itf.hku.backend.entity.Inspection;
import itf.hku.backend.mapper.InspectionMapper;
import itf.hku.backend.service.InspectionService;
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
public class InspectionServiceImpl extends ServiceImpl<InspectionMapper, Inspection> implements InspectionService {

}
