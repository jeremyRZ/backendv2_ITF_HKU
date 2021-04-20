package itf.hku.backend.service.impl;

import itf.hku.backend.entity.Organizations;
import itf.hku.backend.mapper.OrganizationsMapper;
import itf.hku.backend.service.OrganizationsService;
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
public class OrganizationsServiceImpl extends ServiceImpl<OrganizationsMapper, Organizations> implements OrganizationsService {

}
