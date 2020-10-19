### modular表的sql模板
#namespace("modular")

    ### 根据条件查找所有
    #sql("findAllByCondition")
        select modular.*,
               modular_type.title as typeTitle
        from modular
                 inner join modular_type on modular.type = modular_type.id
        where 1 = 1
        #if(cond.id)
            and modular.id = #para(cond.id)
        #else
            #if(cond.type) and modular.type = #para(cond.type) #end
            #if(cond.typeName) and modular.type = (select id from modular_type where name = #para(cond.typeName)) #end
            #if(cond.name) and modular.name = #paraLike(cond.name) #end
            #if(cond.title) and modular.title = #paraLike(cond.title) #end
            #if(cond.englishTitle) and modular.englishTitle = #paraLike(cond.englishTitle) #end
            #if(cond.url) and modular.url = #paraLike(cond.url) #end
            #if(cond.config) and modular.config = #paraLike(cond.config) #end
            #if(cond.status) and modular.status = #para(cond.status) #end
        #end
        order by sort desc
    #end


    ### 分页：根据条件查找
    #sql("findPageByCondition")
        select modular.*,
               modular_type.title as typeTitle
        from modular
                 inner join modular_type on modular.type = modular_type.id
        where 1 = 1
        #if(cond.id)
            and modular.id = #para(cond.id)
        #else
            #if(cond.type) and modular.type = #para(cond.type) #end
            #if(cond.typeName) and modular.type = (select id from modular_type where name = #para(cond.typeName)) #end
            #if(cond.name) and modular.name = #paraLike(cond.name) #end
            #if(cond.title) and modular.title = #paraLike(cond.title) #end
            #if(cond.englishTitle) and modular.englishTitle = #paraLike(cond.englishTitle) #end
            #if(cond.url) and modular.url = #paraLike(cond.url) #end
            #if(cond.config) and modular.config = #paraLike(cond.config) #end
            #if(cond.status) and modular.status = #para(cond.status) #end
        #end
        order by sort desc
    #end


    ### 根据条件精确匹配一条记录
    #sql("findOneByCondition")
        select modular.*,
               modular_type.title as typeTitle
        from modular
                 inner join modular_type on modular.type = modular_type.id
        where 1 = 1
        #if(cond.id)
            and modular.id = #para(cond.id)
        #else
            #if(cond.type) and modular.type = #para(cond.type) #end
            #if(cond.typeName) and modular.type = (select id from modular_type where name = #para(cond.typeName)) #end
            #if(cond.name) and modular.name = #para(cond.name) #end
            #if(cond.title) and modular.title = #para(cond.title) #end
            #if(cond.englishTitle) and modular.englishTitle = #para(cond.englishTitle) #end
            #if(cond.url) and modular.url = #para(cond.url) #end
            #if(cond.config) and modular.config = #para(cond.config) #end
            #if(cond.status) and modular.status = #para(cond.status) #end
        #end
    #end


#end