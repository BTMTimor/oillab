### carousel表的sql模板
#namespace("carousel")

    ### 根据条件查找所有
    #sql("findAllByCondition")
        select * from carousel where 1 = 1
        #if(cond.id)
            and id = #para(cond.id)
        #else
            #if(cond.type) and type = #para(cond.type) #end
            #if(cond.name) and name = #para(cond.name) #end
            #if(cond.url) and url = #paraLike(cond.url) #end
            #if(cond.description) and description = #paraLike(cond.description) #end
            #if(cond.remark) and remark = #paraLike(cond.remark) #end
            #if(cond.interval) and interval = #para(cond.interval) #end
            #if(cond.operatorId) and operatorId = #para(cond.operatorId) #end
            #if(cond.status) and status = #para(cond.status) #end
            order by sort
        #end
    #end


    ### 分页：根据条件查找
    #sql("findPageByCondition")
        select * from carousel where 1 = 1
        #if(cond.id)
            and id = #para(cond.id)
        #else
            #if(cond.type) and type = #para(cond.type) #end
            #if(cond.name) and name = #para(cond.name) #end
            #if(cond.url) and url = #paraLike(cond.url) #end
            #if(cond.description) and description = #paraLike(cond.description) #end
            #if(cond.remark) and remark = #paraLike(cond.remark) #end
            #if(cond.interval) and interval = #para(cond.interval) #end
            #if(cond.operatorId) and operatorId = #para(cond.operatorId) #end
            #if(cond.status) and status = #para(cond.status) #end
            order by sort
        #end
    #end


    ### 根据条件精确匹配一条记录
    #sql("findOneByCondition")
        select * from carousel where 1 = 1
        #if(cond.id)
            and id = #para(cond.id)
        #else
            #if(cond.type) and type = #para(cond.type) #end
            #if(cond.name) and name = #para(cond.name) #end
            #if(cond.url) and url = #para(cond.url) #end
            #if(cond.interval) and interval = #para(cond.interval) #end
            #if(cond.operatorId) and operatorId = #para(cond.operatorId) #end
            #if(cond.status) and status = #para(cond.status) #end
        #end
    #end


#end