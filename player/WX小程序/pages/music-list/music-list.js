const app = getApp()

const s = {
    musicList: [],
    author: '李小双 ',
    title: '秒杀',
};
for (let i = 1; i < 50; i++) {
    s.musicList.push({singer: '苑笙', name: '爱的就是你', index: i})
}

Page({
    onReady: function (e) {
        // 使用 wx.createAudioContext 获取 audio 上下文 context
        this.audioCtx = wx.createAudioContext('myAudio')
    },
//     this.musicList = [];

    data: s,
    //事件处理函数
    bindViewTap: function () {
        wx.navigateTo({
            url: '../logs/logs'
        })
    },
    onReady: function (e) {

    },
    onLoad: function () {


        wx.setNavigationBarTitle({
            title: '节奏控'//页面标题为路由参数
        });
        if (app.globalData.userInfo) {
            this.setData({
                userInfo: app.globalData.userInfo,
                hasUserInfo: true
            })
        } else if (this.data.canIUse) {
            // 由于 getUserInfo 是网络请求，可能会在 Page.onLoad 之后才返回
            // 所以此处加入 callback 以防止这种情况
            app.userInfoReadyCallback = res => {
                this.setData({
                    userInfo: res.userInfo,
                    hasUserInfo: true
                })
            }
        } else {
            // 在没有 open-type=getUserInfo 版本的兼容处理
            wx.getUserInfo({
                success: res => {
                    app.globalData.userInfo = res.userInfo
                    this.setData({
                        userInfo: res.userInfo,
                        hasUserInfo: true
                    })
                }
            })
        }


    },
    getUserInfo: function (e) {
        console.log(e)
        app.globalData.userInfo = e.detail.userInfo
        this.setData({
            userInfo: e.detail.userInfo,
            hasUserInfo: true
        })
    },
    audioPlay: function () {
        if (!this.data.state) {
            this.audioCtx.play();
            this.setData({
                state: true
            });
        }
        else {
            this.audioCtx.pause();
            this.setData({
                state: false
            });
        }
    },
    audioPause: function () {
        this.audioCtx.pause()
    },
    bindKeyInput: function (e) {
        this.setData({
            inputValue: e.detail.value
        })
    },

    toPage: function (e) {
        wx.navigateTo({
            url: '/data'
        })
    },

    ss: function (e) {
        const backgroundAudioManager = wx.getBackgroundAudioManager();
        backgroundAudioManager.stop();
    }
});
