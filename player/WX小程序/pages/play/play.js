const app = getApp()

Page({
    onReady: function (e) {
        // 使用 wx.createAudioContext 获取 audio 上下文 context
        this.audioCtx = wx.createAudioContext('myAudio')
    },
    data: {
        imgUrls: [
            'https://y.gtimg.cn/music/photo_new/T003R720x288M000002ZcnL52cjx9s.jpg?max_age=2592000',
            'https://y.gtimg.cn/music/photo_new/T003R720x288M000003ZBGtI2lLRE1.jpg?max_age=2592000',
            'https://y.gtimg.cn/music/photo_new/T003R720x288M000001cL1B82eozjq.jpg?max_age=2592000'
        ],
        playList: [
            [
                {
                    imageUrl: 'https://p.qpic.cn/music_cover/ibSiagqKjw1zfTgxY7F8CfEiclJ9Cn6atlXWuaBIibXiaXgKbIVul0WuSFw/300?n=1',
                    text: '每日新歌：猫系女生叶炫清带你进入慵懒世界'
                },
                {
                    imageUrl: 'https://p.qpic.cn/music_cover/jF1CHiathfGvgNZrwbCZkzjnWY3Av0ul6CjuaibtHkmcezkbWoppTBgg/300?n=1',
                    text: '古风情书：听一宿梵唱，许一世柔情'
                },
                {
                    imageUrl: 'https://p.qpic.cn/music_cover/53Unr0jHFibpmKbAEqvT1UvGYj9VmCA8vJRS5K5SlYb953ia5EVuWQiaQ/300?n=1',
                    text: 'C.P.E.巴赫：巴洛克到古典主义的启蒙'
                }
            ],
            [
                {
                    imageUrl: 'https://p.qpic.cn/music_cover/wzvG5MwiaSrRPIom1hvTLCI8I27MMAhRxwib7EQpvrZoKHribnhGlWncg/300?n=1',
                    text: 'HipHop Battle ：热血骚年街舞专用'
                },
                {
                    imageUrl: 'https://p.qpic.cn/music_cover/R8unPZMA4Vp5v2Ms96bstxSz79JJx94teiazBicqTYsH47EhWSE3OcCw/300?n=1',
                    text: '冬天暖腿歌单上线！国产电音精选'
                },
                {
                    imageUrl: 'https://p.qpic.cn/music_cover/Dj2OUOncwMUiaEx6VcjEdozSIMhr6nNDyiaUBPhTJmt2HjJWF53Tq3tw/300?n=1',
                    text: '华语金曲原创PK原唱，哪个才是你的菜？'
                }
            ],
            [
                {
                    imageUrl: 'https://p.qpic.cn/music_cover/8HhavvWNIicpyjlv0UnT5TfTiatibaqD1o1U81nhguGicSBrcXxrRxjRww/300?n=1',
                    text: '前桌的你，是我曾去学校听课唯一的理由'
                },
                {
                    imageUrl: 'https://p.qpic.cn/music_cover/r9Js18hQauaHlf3udYvKsh8tvx5iby9Xq94GwFsBauGWJibYQHbBbSeg/300?n=1',
                    text: '励志华语：再不努力跟咸鱼有什么区别'
                },
                {
                    imageUrl: 'https://p.qpic.cn/music_cover/UFS2rA4kUtJXJ0JwvGZvtyCgzib62hfxSY5jO6LGle9NTib7bj2Uu56g/300?n=1',
                    text: '心沉似海，让心思浸没碧蓝海域(男声篇)'
                }
            ]
        ],
        indicatorDots: true,
        autoplay: true,
        circular: true,
        'skip-hidden-item-layout': true,
        interval: 5000,
        duration: 450,
        state: false,

        inputValue: 'http://m10.music.126.net/20180131163308/c4fa72e2c2ebc1142a9e97ca3cddde6e/ymusic/97f5/352d/1093/6cf57aec1444dbf333f757c96d85464c.mp3',


        poster: 'http://p1.music.126.net/kx3m8nhdAdrOL3IQUSSH8Q==/109951163089834919.jpg',
        name: '只对你有感觉（Cover 林俊杰）',
        author: '封茗囧菌',
        src: 'http://m10.music.126.net/20180131142848/69a53f9bc6d6ab51ce8678af81f7e165/ymusic/97f5/352d/1093/6cf57aec1444dbf333f757c96d85464c.mp3',
    },
    //事件处理函数
    bindViewTap: function () {
        wx.navigateTo({
            url: '../logs/logs'
        })
    },
    onLoad: function () {
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
