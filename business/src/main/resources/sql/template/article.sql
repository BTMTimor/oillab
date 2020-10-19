#namespace("article")

    ### 根据条件查找所有, modular.userName as userName
    #sql("findAllByCondition")
        select article.*,
               modular.title as modularTitle,
               article_type.title as typeTitle
        from article
             inner join modular on article.mid = modular.id
             inner join article_type on article.type = article_type.id
        where 1 = 1
        #if(cond.id)
            and article.id = #(cond.id)
        #else
            #if(cond.mid) and article.mid = #para(cond.mid) #end
            #if(cond.mid) and article.mid = #para(cond.mid) #end
            #if(cond.uid) and article.uid = #para(cond.uid) #end
            #if(cond.views) and article.views = #para(cond.views) #end
            #if(cond.title) and article.title like #paraLike(cond.title) #end
            #if(cond.type) and article.type = #para(cond.type) #end
            #if(cond.typeName) and article.type = (select id from article_type where name = #para(cond.typeName)) #end
            #if(cond.author) and article.author = #para(cond.author) #end
            #if(cond.description) and article.description like #paraLike(cond.description) #end
            #if(cond.content) and article.content like #paraLike(cond.content) #end
            #if(cond.beginAddTime && cond.endAddTime)
                and article.addTime between #para(cond.beginAddTime) and #para(cond.endAddTime)
            #end
            #if(cond.beginPubTime && cond.endPubTime)
                and article.pubTime between #para(cond.beginPubTime) and #para(cond.endPubTime)
            #end
            #if(cond.beginLastEditTime && cond.endLastEditTime)
                and article.lastEditTime between #para(cond.beginLastEditTime) and #para(cond.endLastEditTime)
            #end
            #if(cond.status) and article.status = #para(cond.status) #end
        #end
        order by article.pubTime #(cond.sort ? ", " + cond.sort : "") #(cond.sortOrder??"desc")
    #end

    #sql("findPageByCondition")
        select article.*,
               modular.title as modularTitle,
               article_type.title as typeTitle
        from article
             inner join modular on article.mid = modular.id
             inner join article_type on article.type = article_type.id
        where 1 = 1
        #if(cond.id)
            and article.id = #(cond.id)
        #else
            #if(cond.mid) and article.mid = #para(cond.mid) #end
            #if(cond.uid) and article.uid = #para(cond.uid) #end
            #if(cond.views) and article.views = #para(cond.views) #end
            #if(cond.title) and article.title like #paraLike(cond.title) #end
            #if(cond.type) and article.type = #para(cond.type) #end
            #if(cond.typeName) and article.type = (select id from article_type where name = #para(cond.typeName)) #end
            #if(cond.author) and article.author = #para(cond.author) #end
            #if(cond.description) and article.description like #paraLike(cond.description) #end
            #if(cond.content) and article.content like #paraLike(cond.content) #end
            #if(cond.beginAddTime && cond.endAddTime)
                and article.addTime between #para(cond.beginAddTime) and #para(cond.endAddTime)
            #end
            #if(cond.beginPubTime && cond.endPubTime)
                and article.pubTime between #para(cond.beginPubTime) and #para(cond.endPubTime)
            #end
            #if(cond.beginLastEditTime && cond.endLastEditTime)
                and article.lastEditTime between #para(cond.beginLastEditTime) and #para(cond.endLastEditTime)
            #end
            #if(cond.status) and article.status = #para(cond.status) #end
        #end
        order by article.pubTime #(cond.sort ? ", " + cond.sort : "") #(cond.sortOrder??"desc")
    #end

    #sql("findOneByCondition")
        select article.*,
               modular.title as modularTitle,
               article_type.title as typeTitle
        from article
             inner join modular on article.mid = modular.id
             inner join article_type on article.type = article_type.id
        where 1 = 1
        #if(cond.id)
            and article.id = #(cond.id)
        #else
            #if(cond.mid) and article.mid = #para(cond.mid) #end
            #if(cond.uid) and article.uid = #para(cond.uid) #end
            #if(cond.views) and article.views = #para(cond.views) #end
            #if(cond.title) and article.title like #paraLike(cond.title) #end
            #if(cond.type) and article.type = #para(cond.type) #end
            #if(cond.typeName) and article.type = (select id from article_type where name = #para(cond.typeName)) #end
            #if(cond.author) and article.author = #para(cond.author) #end
            #if(cond.status) and article.status = #para(cond.status) #end
        #end
        order by article.pubTime #(cond.sort ? ", " + cond.sort : "") #(cond.sortOrder??"desc")
        limit 1
    #end
#end