package com.randioo.majiang_collections_server.module.fight.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.randioo.mahjong_public_server.protocol.Fight.FightQueryGameConfigRequest;
import com.randioo.majiang_collections_server.entity.bo.Role;
import com.randioo.majiang_collections_server.module.fight.service.FightService;
import com.randioo.randioo_server_base.annotation.PTAnnotation;
import com.randioo.randioo_server_base.cache.RoleCache;
import com.randioo.randioo_server_base.template.IActionSupport;

@Controller
@PTAnnotation(FightQueryGameConfigRequest.class)
public class FightQueryGameConfigAction implements IActionSupport {

    @Autowired
    private FightService fightService;

    @Override
    public void execute(Object data, Object session) {
        FightQueryGameConfigRequest request = (FightQueryGameConfigRequest) data;
        Role role = (Role) RoleCache.getRoleBySession(session);
        fightService.queryGameConfig(role);
    }
}
