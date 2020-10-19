### html_template表的sql模板
#namespace("template")

    ### 根据条件查找所有
    #sql("findAllByCondition")
        select * from html_template where 1 = 1
        #if(cond.id)
            and id = #para(cond.id)
        #else
            #if(cond.type) and type = #paraLike(cond.type) #end
            #if(cond.status) and status = #para(cond.status) #end
        #end
    #end


    ### 分页：根据条件查找
    #sql("findPageByCondition")
        select * from html_template where 1 = 1
        #if(cond.id)
            and id = #para(cond.id)
        #else
            #if(cond.name) and name like #paraLike(cond.name) #end
            #if(cond.type) and type = #para(cond.type) #end
            #if(cond.status) and status = #para(cond.status) #end
        #end
    #end


    ### 根据条件精确匹配一条记录
    #sql("findOneByCondition")
        select * from html_template where 1 = 1
        #if(cond.id)
            and id = #para(cond.id)
        #else
            #if(cond.name) and name = #para(cond.name) #end
            #if(cond.type) and type = #para(cond.type) #end
            #if(cond.status) and status = #para(cond.status) #end
        #end
    #end


#end