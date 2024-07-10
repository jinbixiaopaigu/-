import request from '@/utils/request'

// 查询健康数据列表
export function listHealthdata(query) {
  return request({
    url: '/hcare/healthdata/list',
    method: 'get',
    params: query
  })
}

// 查询健康数据详细
export function getHealthdata(hcDataid) {
  return request({
    url: '/hcare/healthdata/' + hcDataid,
    method: 'get'
  })
}

// 新增健康数据
export function addHealthdata(data) {
  return request({
    url: '/hcare/healthdata',
    method: 'post',
    data: data
  })
}

// 修改健康数据
export function updateHealthdata(data) {
  return request({
    url: '/hcare/healthdata',
    method: 'put',
    data: data
  })
}

// 删除健康数据
export function delHealthdata(hcDataid) {
  return request({
    url: '/hcare/healthdata/' + hcDataid,
    method: 'delete'
  })
}
