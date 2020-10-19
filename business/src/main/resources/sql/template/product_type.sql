### product_type表的sql模板
#namespace("product_type")

    ### 根据条件查找所有
    #sql("findAllByCondition")
        select * from product_type where 1 = 1
        #if(cond.id)
            and id = #para(cond.id)
        #else
            #if(cond.name) and name = #paraLike(cond.name) #end
            #if(cond.category) and category = #para(cond.category) #end
            #if(cond.status) and status = #para(cond.status) #end
            #if(cond.description) and description = #paraLike(cond.description) #end
        #end
    #end


    ### 分页：根据条件查找
    #sql("findPageByCondition")
        select * from product_type where 1 = 1
        #if(cond.id)
            and id = #para(cond.id)
        #else
            #if(cond.name) and name = #paraLike(cond.name) #end
            #if(cond.category) and category = #para(cond.category) #end
            #if(cond.status) and status = #para(cond.status) #end
            #if(cond.description) and description = #paraLike(cond.description) #end
        #end
    #end


    ### 根据条件精确匹配一条记录
    #sql("findOneByCondition")
        select * from product_type where 1 = 1
        #if(cond.id)
            and id = #para(cond.id)
        #else
            #if(cond.name) and name = #para(cond.name) #end
            #if(cond.category) and category = #para(cond.category) #end
            #if(cond.status) and status = #para(cond.status) #end
            #if(cond.description) and description = #paraLike(cond.description) #end
        #end
    #end


#end