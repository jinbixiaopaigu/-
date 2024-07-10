import request from '@/utils/request'

// 查询摔倒检测列表
export function listFalldetection(query) {
  return request({
    url: '/hcare/falldetection/list',
    method: 'get',
    params: query
  })
}

// 查询摔倒检测详细
export function getFalldetection(hcDataid) {
  return request({
    url: '/hcare/falldetection/' + hcDataid,
    method: 'get'
  })
}

// 新增摔倒检测
export function addFalldetection(data) {
  return request({
    url: '/hcare/falldetection',
    method: 'post',
    data: data
  })
}

// 修改摔倒检测
export function updateFalldetection(data) {
  return request({
    url: '/hcare/falldetection',
    method: 'put',
    data: data
  })
}

// 删除摔倒检测
export function delFalldetection(hcDataid) {
  return request({
    url: '/hcare/falldetection/' + hcDataid,
    method: 'delete'
  })
}
