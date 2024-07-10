@Extend (Column)function commonColumnStyle(){
  .backgroundColor("#FFFFFF")
  .width("92%")
  .borderRadius("5vp")
}

@Component
export default struct Rehabilitation {
  build(){
    Refresh({ friction: 62, offset: "16vp", refreshing: false }) {
      Scroll() {
        Column() {

          //标题栏
          Row() {
            Text("康复计划")
              .width("84%")
              .height("100%")
              .fontSize("22fp")
              .fontColor("#FFFFFF")
            Button("编辑")
              .width("18%")
              .height("90%")
              .fontColor("#000000")
              .fontSize("13")
              .backgroundColor("#FFFFFF")
          }
          .width("92%")
          .height("7%")
          .margin({ top: "1%" })

          //康复计划内容
          Column() {
            Row() {
              CheckboxGroup()
                .width("10%")
                .height("60%")
                .selectAll(true)
              Text("第一阶段：初始评估与急性管理")
                .width("81%")
                .height("100%")
                .fontSize("18fp")
            }
            .width("95%")
            .height("25%")
            Row() {
              CheckboxGroup()
                .width("10%")
                .height("60%")
                .selectAll(true)
              Text("第二阶段：功能恢复与增强")
                .width("81%")
                .height("100%")
                .fontSize("18fp")
            }
            .width("95%")
            .height("25%")
            Row() {
              CheckboxGroup()
                .width("10%")
                .height("60%")
                .selectAll(true)
              Text("第三阶段：技能整合与应用")
                .width("81%")
                .height("100%")
                .fontSize("18fp")
            }
            .width("95%")
            .height("25%")
            Row() {
              CheckboxGroup()
                .width("10%")
                .height("60%")
                .selectAll(false)
              Text("第四阶段：维持与长期改善")
                .width("81%")
                .height("100%")
                .fontSize("18fp")
            }
            .width("95%")
            .height("25%")
          }
          .height("30%")
          .margin({ top: "2%" })
          .commonColumnStyle()

          //肌电图
          Column() {
            // Button("开始")
            //   .width("20%")
            //   .height("15%")
            // Text("肌电图")
            //   .width("100%")
            //   .height("85%")
            //   .textAlign(TextAlign.Center)
            //   .fontSize("40fp")
            Image($r('app.media.test2'))
              .width("90%")
              .height("90%")

          }
          .height("35%")
          .margin({ top: "2%" })
          .commonColumnStyle()

          //康复历史
          Column() {
            Row() {
              Image($r('app.media.effort'))
                .width("10%")
                .height("90%")
              Text("康复历史")
                .width("90%")
                .height("100%")
                .fontSize("22fp")
            }
            .width("95%")
            .height("20%")
            .alignItems(VerticalAlign.Center)
            .justifyContent(FlexAlign.Start)
            Text("2023年1月10日，第一阶段完成，开始康复治疗")
              .width("95%")
              .height("40%")
              .fontSize("20fp")
            Text("2023年1月11日，第一次使用肌电手套康复治疗")
              .width("95%")
              .height("40%")
              .fontSize("20fp")
          }
          .commonColumnStyle()
          .height("24%")
          .margin({top:"2%",bottom:"0%"})
        }
      }
      .width("100%")
      .height("100%")
      .scrollable(ScrollDirection.Vertical)
      .scrollBar(BarState.Auto)
      .edgeEffect(EdgeEffect.None)
    }
    .width("100%")
    .height("100%")
  }
}