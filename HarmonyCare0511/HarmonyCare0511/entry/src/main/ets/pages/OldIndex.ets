import Home from '../components/Home'
import Mine from '../components/Mine'
import Rehabilitation from '../components/Rehabilitation'
import Routine1 from '../components/Routine1'
@Entry
@Component
struct OldIndex {

  /**
   * In low-code mode, do not add anything to the build function, as it will be
   * overwritten by the content generated by the .visual file in the build phase.
   */
  build() {
    Column() {
      Tabs({ barPosition: BarPosition.End }) {
        TabContent() {
              Home()
        }
        .linearGradient({direction:GradientDirection.Bottom,colors:[[0x007FFF,0.0],[0xAFEEEE,0.7]]})
        .tabBar({ icon: $r('app.media.home'), text: "首页" })
        TabContent() {
              Routine1()
        }
        .linearGradient({direction:GradientDirection.Bottom,colors:[[0x007FFF,0.0],[0xAFEEEE,0.7]]})
        .tabBar({ icon: $r('app.media.medical_files'), text: "常规" })
        TabContent() {
              Rehabilitation()
        }
        .linearGradient({direction:GradientDirection.Bottom,colors:[[0x007FFF,0.0],[0xAFEEEE,0.7]]})
        .tabBar({ icon: $r('app.media.recovered'), text: "康复" })
        TabContent() {
              Mine()
        }
        .backgroundColor("#EDEDED")
        .tabBar({ icon: $r('app.media.user'), text: "我的" })
      }
      .width("100%")
      .height("100%")
      .barHeight("8%")
    }
    .width("100%")
    .height("100%")
  }
}