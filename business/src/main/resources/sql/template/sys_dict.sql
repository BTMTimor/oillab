### dict表的sql模板
#namespace("sys_dict")

    ### 根据条件查找所有
    #sql("findAllByCondition")
select sys_dict.*, sys_dict_type.name as typeName from sys_dict
        join sys_dict_type on sys_dict.type = sys_dict_type.id
        where 1 = 1
        #if(cond.id)
            and id = #para(cond.id)
        #else
            #if(cond.type) and type = #para(cond.type) #end
            #if(cond.name) and name = #paraLike(cond.name) #end
            #if(cond.value) and value = #paraLike(cond.value) #end
            #if(cond.description) and description = #paraLike(cond.description) #end
            #if(cond.sort) and sort = #paraLike(cond.sort) #end
            #if(cond.status) and status = #para(cond.status) #end
        #end
    #end


    ### 分页：根据条件查找
    #sql("findPageByCondition")
        select sys_dict.*, sys_dict_type.name as typeName from sys_dict
        join sys_dict_type on sys_dict.type = sys_dict_type.id
        where 1 = 1
        #if(cond.id)
            and id = #para(cond.id)
        #else
            #if(cond.type) and type = #para(cond.type)
            #else
                #if(cond.typeName) and type = (select id from sys_dict_type where name = #para(cond.typeName)) #end
            #end

            #if(cond.name) and name = #paraLike(cond.name) #end
            #if(cond.value) and value = #paraLike(cond.value) #end
            #if(cond.description) and description = #paraLike(cond.description) #end
            #if(cond.sort) and sort = #paraLike(cond.sort) #end
            #if(cond.status) and status = #para(cond.status) #end
        #end
    #end


    ### 根据条件精确匹配一条记录
    #sql("findOneByCondition")
        select * from sys_dict where 1 = 1
        #if(cond.id)
            and id = #para(cond.id)
        #else
            #if(cond.type) and type = #para(cond.type) #end
            #if(cond.name) and name = #para(cond.name) #end
            #if(cond.value) and value = #para(cond.value) #end
            #if(cond.description) and description = #para(cond.description) #end
            #if(cond.sort) and sort = #para(cond.sort) #end
            #if(cond.status) and status = #para(cond.status) #end
        #end
    #end


#end