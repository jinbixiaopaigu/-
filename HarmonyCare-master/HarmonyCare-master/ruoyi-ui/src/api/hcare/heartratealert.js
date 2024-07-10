import request from '@/utils/request'

// 查询心率异常列表
export function listHeartratealert(query) {
  return request({
    url: '/hcare/heartratealert/list',
    method: 'get',
    params: query
  })
}

// 查询心率异常详细
export function getHeartratealert(hcDataid) {
  return request({
    url: '/hcare/heartratealert/' + hcDataid,
    method: 'get'
  })
}

// 新增心率异常
export function addHeartratealert(data) {
  return request({
    url: '/hcare/heartratealert',
    method: 'post',
    data: data
  })
}

// 修改心率异常
export function updateHeartratealert(data) {
  return request({
    url: '/hcare/heartratealert',
    method: 'put',
    data: data
  })
}

// 删除心率异常
export function delHeartratealert(hcDataid) {
  return request({
    url: '/hcare/heartratealert/' + hcDataid,
    method: 'delete'
  })
}
