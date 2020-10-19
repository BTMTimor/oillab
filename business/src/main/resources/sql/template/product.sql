### product表的sql模板
#namespace("product")

    ### 根据条件查找所有
    #sql("findAllByCondition")
        select product.*,
               product_category.name as categoryName,
               product_type.name as typeName
        from product
        join product_type on product.type = product_type.id
        join product_category on product.category = product_category.id
        where 1 = 1
        #if(cond.id)
            and product.id = #para(cond.id)
        #else
            #if(cond.name) and product.name = #paraLike(cond.name) #end
            #if(cond.category) and product.category = #para(cond.category) #end
            #if(cond.type) and product.type = #para(cond.type) #end
            #if(cond.model) and product.model = #paraLike(cond.model) #end
            #if(cond.status) and product.status = #para(cond.status) #end
            ### 这些可以不要
            #if(cond.coverImg) and product.coverImg = #paraLike(cond.coverImg) #end
            #if(cond.description) and product.description = #paraLike(cond.description) #end
            #if(cond.introduction) and product.introduction = #paraLike(cond.introduction) #end
            #if(cond.resource) and product.resource = #paraLike(cond.resource) #end
        #end
    #end


    ### 分页：根据条件查找
    #sql("findPageByCondition")
        select product.*,
               product_category.name as categoryName,
               product_type.name as typeName
        from product
        join product_type on product.type = product_type.id
        join product_category on product.category = product_category.id
        where 1 = 1
        #if(cond.id)
            and product.id = #para(cond.id)
        #else
            #if(cond.name) and product.name = #paraLike(cond.name) #end
            #if(cond.category) and product.category = #para(cond.category) #end
            #if(cond.type) and product.type = #para(cond.type) #end
            #if(cond.model) and product.model = #paraLike(cond.model) #end
            #if(cond.status) and product.status = #para(cond.status) #end
            ### 这些可以不要
            #if(cond.coverImg) and product.coverImg = #paraLike(cond.coverImg) #end
            #if(cond.description) and product.description = #paraLike(cond.description) #end
            #if(cond.introduction) and product.introduction = #paraLike(cond.introduction) #end
            #if(cond.resource) and product.resource = #paraLike(cond.resource) #end
        #end
    #end


    ### 根据条件精确匹配一条记录
    #sql("findOneByCondition")
        select product.*,
               product_category.name as categoryName,
               product_type.name as typeName
        from product
        join product_type on product.type = product_type.id
        join product_category on product.category = product_category.id
        where 1 = 1
        #if(cond.id)
            and product.id = #para(cond.id)
        #else
            #if(cond.name) and product.name = #para(cond.name) #end
            #if(cond.category) and product.category = #para(cond.category) #end
            #if(cond.type) and product.type = #para(cond.type) #end
            #if(cond.model) and product.model = #para(cond.model) #end
            #if(cond.status) and product.status = #para(cond.status) #end
        #end
    #end


#end