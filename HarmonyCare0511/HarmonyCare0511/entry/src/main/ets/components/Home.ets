import call from '@ohos.telephony.call'

@Extend (Column)function commonColumnStyle(){
  .backgroundColor("#FFFFFF")
  .width("92%")
  .borderRadius("5vp")
}
@Component
export default struct Home {

    build(){
      Refresh({ friction: 62, offset: "16vp", refreshing: false }) {
        //Scroll的次一级子部件不能设置宽高属性，否则将无法滑动
        Scroll() {
          Column() {

            //标题栏
            Row() {
              Text($r('app.string.home_page'))
                .fontColor("#FFFFFF")
                .width("88%")
                .height("100%")
                .fontSize("30fp")
              Image($r('app.media.refresh'))
                .width("10%")
                .height("70%")
            }
            .width("92%")
            .height("7%")
            .margin({ top: "1%" })

            //老人状态
            Column() {
              Row() {
                Image($r('app.media.health'))
                  .width("10%")
                  .height("100%")
                Text($r('app.string.Elderly_status'))
                  .width("90%")
                  .height("100%")
                  .fontSize("22fp")
              }
              .width("95%")
              .height("30%")
              Text($r('app.string.Elderly_status_value'))
                .width("95%")
                .height("40%")
                .fontColor("#050505")
                .fontSize("30fp")
                .fontWeight(FontWeight.Bold)
              Row() {
                Row() {
                  Image($r('app.media.analysis'))
                    .width("9%")
                    .height("60%")
                    .margin({ left: "7%", right: "2vp" })
                    .padding({ top: "0vp", bottom: "0vp", left: "0vp", right: "0vp" })
                  Text($r('app.string.Recent_status'))
                    .width("67%")
                    .height("100%")
                  Image($r('app.media.right'))
                    .width("10%")
                    .height("80%")
                }
                .alignItems(VerticalAlign.Center)
                .width("50%")
                .height("100%")
                .borderWidth("1vp")
                .borderColor("#9b9b9b")
                .borderRadius("13vp")
              }
              .width("95%")
              .height("20%")
            }
            .height("17%")
            .margin({ top: "1%" })
            .commonColumnStyle()

            //跌倒检测
            Column() {
              Row() {
                Image($r('app.media.fall_recognition'))
                  .width("10%")
                  .height("100%")
                Text($r('app.string.Fall_detection'))
                  .width("90%")
                  .height("100%")
                  .fontSize("22fp")
              }
              .width("95%")
              .height("30%")
              Text($r('app.string.Fall_detection_value'))
                .width("95%")
                .height("70%")
                .fontColor("#050505")
                .fontSize("35fp")
                .fontWeight(FontWeight.Bold)
            }
            .height("13%")
            .margin({ top: "2%" })
            .padding({top:"1%"})
            .commonColumnStyle()

            //老人位置
            Column() {
              Row() {
                Image($r('app.media.location'))
                  .width("10%")
                  .height("80%")
                Text($r('app.string.elderly_location'))
                  .width("90%")
                  .height("100%")
                  .fontSize("22fp")
              }
              .width("95%")
              .height("30%")
              Text($r('app.string.elderly_location_value'))
                .width("95%")
                .height("43%")
                .fontColor("#000000")
                .margin({ top: "1%" })
                .fontSize("20fp")
                .fontWeight(FontWeight.Bold)
              Button("一键报警")
                .width("30%")
                .height("20%")
                .onClick(() => {
                  let isSupport = call.hasVoiceCapability();
                  if (!isSupport) {
                    console.info(" support voice capability, return");
                    return;
                  }
                  call.makeCall("120", (err) => {
                    if (!err) {
                      console.info(" make call success.");

                    } else {
                      console.info("make call fail, err is:" + JSON.stringify(err));
                    }
                  });
                })
            }
            .height("20%")
            .margin({ top: "2%" })
            .commonColumnStyle()

            //老人睡眠状况
            Column() {
              Row() {
                Image($r('app.media.sleep'))
                  .width("10%")
                  .height("90%")
                Text("老人睡眠状况")
                  .width("75%")
                  .height("100%")
                  .fontSize("22fp")
                Text("良好")
                  .width("15%")
                  .height("100%")
                  .fontColor("#73e796")
                  .fontSize("22fp")
                  .fontWeight(FontWeight.Bold)
              }
              .width("95%")
              .height("30%")
              Column() {
                Row() {
                  Text("睡眠开始时间：")
                    .width("85%")
                    .height("100%")
                    .fontSize("13fp")
                  Text("21:00")
                    .width("15%")
                    .height("100%")
                    .fontSize("17fp")
                    .fontWeight(FontWeight.Bold)
                }
                .width("100%")
                .height("33.3%")
                Row() {
                  Text("睡眠结束时间：")
                    .width("85%")
                    .height("100%")
                    .fontSize("13fp")
                  Text("6:00")
                    .width("15%")
                    .height("100%")
                    .fontSize("17fp")
                    .fontWeight(FontWeight.Bold)
                }
                .width("100%")
                .height("33.3%")
                Row() {
                  Text("总睡眠时间：")
                    .width("85%")
                    .height("100%")
                    .fontSize("13fp")
                  Text("9")
                    .width("5%")
                    .height("100%")
                    .fontSize("17fp")
                    .fontWeight(FontWeight.Bold)
                  Text("小时")
                    .width("10%")
                    .height("100%")
                    .fontSize("15fp")
                }
                .width("100%")
                .height("33.3%")
              }
              .width("95%")
              .height("69%")
            }
            .height("20%")
            .margin({ top: "2%" })
            .commonColumnStyle()

            //康复计划
            Column() {
              Row() {
                Image($r('app.media.plan'))
                  .width("10%")
                  .height("90%")
                Text("康复计划")
                  .width("90%")
                  .height("100%")
                  .fontSize("22fp")
              }
              .width("95%")
              .height("30%")
              .alignItems(VerticalAlign.Center)
              Row() {
                Text("已完成：")
                  .width("30%")
                  .height("80%")
                  .fontSize("18fp")
                Text("75%")
                  .width("60%")
                  .height("80%")
                  .fontSize("18fp")
                  .fontWeight(FontWeight.Bold)
              }
              .width("95%")
              .height("35%")
              .margin({ top: "5%" })
              Progress({ value: 75 })
                .width("95%")
                .height("20%")
                .color("#20ee5e")
            }
            .height("17%")
            .margin({ top: "2%" })
            .commonColumnStyle()

            //历史通知
            Column() {
              Row() {
                Image($r('app.media.history'))
                  .width("10%")
                  .height("80%")
                Text("历史通知")
                  .width("90%")
                  .height("100%")
                  .fontSize("22fp")
              }
              .width("95%")
              .height("27%")
              Column() {
                Row() {
                  Text("老人已醒")
                    .width("70%")
                    .height("100%")
                    .margin({ top: "0%", bottom: "0%", left: "0%", right: "0%" })
                    .fontSize("18fp")
                  Text("10分钟前")
                    .width("30%")
                    .height("100%")
                    .fontColor("#9b9b9b")
                    .fontSize("15fp")
                }
                .width("100%")
                .height("40%")
                Text("昨日睡眠开始时间：21:00\n昨日睡眠结束时间：6:00")
                  .width("100%")
                  .height("60%")
                  .fontSize("20fp")
              }
              .width("95%")
              .height("69%")
              .margin({ top: "1%" })
            }
            .height("20%")
            .margin({ top: "2%",bottom:"2%" })
            .commonColumnStyle()
          }

        }
        .width("100%")
        .height("100%")
        .scrollable(ScrollDirection.Vertical)
        .scrollBar(BarState.On)
        .edgeEffect(EdgeEffect.None)
      }
      .width("100%")
      .height("100%")
    }
}