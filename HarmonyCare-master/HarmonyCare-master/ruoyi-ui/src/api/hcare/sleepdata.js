import request from '@/utils/request'

// 查询睡眠数据列表
export function listSleepdata(query) {
  return request({
    url: '/hcare/sleepdata/list',
    method: 'get',
    params: query
  })
}

// 查询睡眠数据详细
export function getSleepdata(hcDataid) {
  return request({
    url: '/hcare/sleepdata/' + hcDataid,
    method: 'get'
  })
}

// 新增睡眠数据

export function addSleepdata(data) {
  return request({
    url: '/hcare/sleepdata',
    method: 'post',
    data: data
  })
}

// 修改睡眠数据

export function updateSleepdata(data) {
  return request({
    url: '/hcare/sleepdata',
    method: 'put',
    data: data
  })
}

// 删除睡眠数据

export function delSleepdata(hcDataid) {
  return request({
    url: '/hcare/sleepdata/' + hcDataid,
    method: 'delete'
  })
}
