package com.stathis.sportseventviewer.util

import com.stathis.sportseventviewer.models.IconModel

object IconHelper {

    fun getSports(): List<IconModel> {
        return listOf(
            IconModel("SOCCER", "https://upload.wikimedia.org/wikipedia/commons/thumb/e/ec/Soccer_ball.svg/1200px-Soccer_ball.svg.png"),
            IconModel("BASKETBALL", "https://upload.wikimedia.org/wikipedia/commons/thumb/7/72/Basketball_Clipart.svg/768px-Basketball_Clipart.svg.png"),
            IconModel("TENNIS", "https://www.pngall.com/wp-content/uploads/2016/03/Tennis-Ball-Transparent.png"),
            IconModel("TABLE TENNIS", "https://upload.wikimedia.org/wikipedia/commons/thumb/8/8d/Table_tennis.svg/1101px-Table_tennis.svg.png"),
            IconModel("VOLLEYBALL", "https://w7.pngwing.com/pngs/32/680/png-transparent-blue-white-and-yellow-volleyball-volleyball-net-mikasa-sports-volleyball-sport-orange-sporting-goods.png"),
            IconModel("ESPORTS", "https://e7.pngegg.com/pngimages/976/842/png-clipart-esport-logo-logo-esport-logo-leave-the-material.png"),
            IconModel("ICE HOCKEY", "https://www.pngall.com/wp-content/uploads/2/Ice-Hockey-PNG-Clipart.png"),
            IconModel("HANDBALL", "https://upload.wikimedia.org/wikipedia/commons/thumb/4/40/Ballon_de_handball.svg/1027px-Ballon_de_handball.svg.png"),
            IconModel("BEACH VOLLEYBALL", "https://cdn.imgbin.com/11/16/20/imgbin-volleyball-volleyball-blue-yellow-and-white-ball-illustration-GMgH1Wq7BNi6xk0yy4S8fd9ik.jpg"),
            IconModel("SNOOKER", "https://pngset.com/images/billiard-ball-furniture-room-indoors-table-transparent-png-335265.png"),
            IconModel("BADMINTON", "https://w7.pngwing.com/pngs/218/90/png-transparent-badminton-racket-illustration-badminton-racket-shuttlecock-badminton-photography-sport-sporting-goods.png"),
        )
    }
}