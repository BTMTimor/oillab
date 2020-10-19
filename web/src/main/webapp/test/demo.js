function renderPagination(page){
    let pagination = {
        firstPage: 1,// 有些地方0为第一页
        pageSize: page.pageSize ? page.pageSize : 10,
        totalPage: page.totalPage ? page.totalPage : 1,
        totalRow: page.totalRow ? page.totalRow : 1,
        pageNumber: page.pageNumber ? page.pageNumber : 1,
        pageNumbers: [1, 2, 3, 4, 5, -1, 97, 98, 99],
        hasMorePages: false,
    };
    let pages = [];
    let temp = pagination.totalPage - pagination.firstPage + 1;
    temp = (temp >= 10) ? 10 : temp;
    if (9 >= temp || 10 >= pagination.totalPage){
        console.log(temp);
        // 填充页码（temp in [0, 9]）
        for (let i = 0; i < temp; i++) {
            pages[i] = i + 1;
        }
        pagination.pageNumbers = pages;
        return pagination;
    }
    // 10 === temp
    const aSize = 4;
    // 不在结尾附近（前面或中间）

    let start1 = pagination.pageNumber > 3
        ? pagination.pageNumber - 2 : pagination.firstPage;
    let end1 = start1 + aSize < pagination.totalPage ? start1 + aSize : pagination.totalPage;
    let start2 = (end1 + aSize < pagination.totalPage ? pagination.totalPage - aSize : end1) + 1;
    if(pagination.pageNumber >= pagination.totalPage - aSize) {
        start2 = pagination.totalPage - aSize;
        start1 = 1;
        end1 = pagination.totalPage - start2;
    }
    pagination.hasMorePages = (start2 !== end1);
    console.log(temp, start1, end1, start2, temp - 1);

    let i, j;
    // 填充前半部分的页码（共5页）
    for (i = 0; i <= end1 - start1; i++) {
        pages[i] = start1 + i;
    }
    if (start2 !== end1) pages[i++] = -1;
    // 填充后半部分的页码
    if(pagination.totalPage - start2 > 0) {
        for (j = 0; j <= pagination.totalPage - start2; i++, j++) {
            pages[i] = start2 + j;
        }
    }
    pagination.pageNumbers = pages;
    return pagination;
}