### dict表的sql模板
#namespace("sys_dict_type")

    ### 根据条件查找所有
    #sql("findAllByCondition")
        select * from sys_dict_type where 1 = 1
        #if(cond.id)
            and id = #para(cond.id)
        #else
            #if(cond.name) and name = #paraLike(cond.name) #end
        #end
    #end


    ### 分页：根据条件查找
    #sql("findPageByCondition")
        select * from sys_dict_type where 1 = 1
        #if(cond.id)
            and id = #para(cond.id)
        #else
            #if(cond.name) and name = #paraLike(cond.name) #end
        #end
    #end


    ### 根据条件精确匹配一条记录
    #sql("findOneByCondition")
        select * from sys_dict_type where 1 = 1
        #if(cond.id)
            and id = #para(cond.id)
        #else
            #if(cond.name) and name = #para(cond.name) #end
        #end
    #end


#end