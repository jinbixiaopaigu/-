import request from '@/utils/request'

// 查询用药提醒列表
export function listMedicationreminder(query) {
  return request({
    url: '/hcare/medicationreminder/list',
    method: 'get',
    params: query
  })
}

// 查询用药提醒详细
export function getMedicationreminder(hcReminderid) {
  return request({
    url: '/hcare/medicationreminder/' + hcReminderid,
    method: 'get'
  })
}

// 新增用药提醒
export function addMedicationreminder(data) {
  return request({
    url: '/hcare/medicationreminder',
    method: 'post',
    data: data
  })
}

// 修改用药提醒
export function updateMedicationreminder(data) {
  return request({
    url: '/hcare/medicationreminder',
    method: 'put',
    data: data
  })
}

// 删除用药提醒
export function delMedicationreminder(hcReminderid) {
  return request({
    url: '/hcare/medicationreminder/' + hcReminderid,
    method: 'delete'
  })
}
