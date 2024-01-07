package com.alemicode.instagramprofilescreen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alemicode.ui_toolkit.component.DefaultTopBar
import com.alemicode.ui_toolkit.image.RoundedImage
import com.alemicode.ui_toolkit.text.BodyText
import com.alemicode.ui_toolkit.text.BoldText
import com.alemicode.ui_toolkit.text.CustomAnnotatedText
import com.alemicode.ui_toolkit.text.SemiBoldText
import com.alemicode.ui_toolkit.text.TitleText
import com.alemicode.ui_toolkit.util.TextType

@ExperimentalFoundationApi
@Composable
fun InstagramScreen() {
    var selectedTabIndex by remember {
        mutableStateOf(0)
    }
    Column(modifier = Modifier.fillMaxWidth()) {
        DefaultTopBar(
            titleRes = com.alemicode.ui_toolkit.R.string.profile_url,
            content = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_bell),
                    contentDescription = null,
                    tint = Color.Black,
                    modifier = Modifier
                        .padding(horizontal = 5.dp)
                        .size(24.dp)
                )
                Icon(
                    painter = painterResource(id = R.drawable.ic_dotmenu),
                    contentDescription = null,
                    tint = Color.Black,
                    modifier = Modifier
                        .padding(horizontal = 5.dp)
                        .size(20.dp)

                )
            }
        )
        Spacer(modifier = Modifier.height(4.dp))
        ProfileSection()
        Spacer(modifier = Modifier.height(25.dp))
        ButtonSection(modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(25.dp))
        HighlightSection(
            highlights = listOf(
                ImageWithText(
                    image = painterResource(id = R.drawable.youtube),
                    text = "YouTube"
                ),
                ImageWithText(
                    image = painterResource(id = R.drawable.qa),
                    text = "Q&A"
                ),
                ImageWithText(
                    image = painterResource(id = R.drawable.discord),
                    text = "Discord"
                ),
                ImageWithText(
                    image = painterResource(id = R.drawable.telegram),
                    text = "Telegram"
                ),
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        PostTabView(
            imageWithTexts = listOf(
                ImageWithText(
                    image = painterResource(id = R.drawable.ic_grid),
                    text = "Posts"
                ),
                ImageWithText(
                    image = painterResource(id = R.drawable.ic_reels),
                    text = "Reels"
                ),
                ImageWithText(
                    image = painterResource(id = R.drawable.ic_igtv),
                    text = "IGTV"
                ),
                ImageWithText(
                    image = painterResource(id = R.drawable.profile),
                    text = "Profile"
                ),
            )
        ) {
            selectedTabIndex = it
        }
        when (selectedTabIndex) {
            0 -> PostSection(
                posts = listOf(
                    painterResource(id = R.drawable.kmm),
                    painterResource(id = R.drawable.intermediate_dev),
                    painterResource(id = R.drawable.master_logical_thinking),
                    painterResource(id = R.drawable.bad_habits),
                    painterResource(id = R.drawable.multiple_languages),
                    painterResource(id = R.drawable.learn_coding_fast),
                ),
                modifier = Modifier.fillMaxWidth()
            )
        }

    }
}

@Composable
fun ProfileSection() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {
            RoundedImage(
                image = painterResource(id = R.drawable.profile), modifier = Modifier
                    .size(100.dp)
                    .border(
                        width = 1.dp,
                        color = Color.LightGray,
                        shape = CircleShape
                    )
                    .aspectRatio(1f, matchHeightConstraintsFirst = true)
                    .padding(3.dp)

            )
            Spacer(modifier = Modifier.width(16.dp))
            StatSection()
        }
        ProfileDescription(
            displayName = "Mohamad Alemi",
            description = "Android Engineer and Real Madrid Fan",
            url = "https://github.com/alemicode",
        )
    }
}

@Composable
fun StatSection() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = Modifier.fillMaxWidth()
    ) {
        ProfileStat(numberText = "601", text = "Posts")
        ProfileStat(numberText = "100K", text = "Followers")
        ProfileStat(numberText = "72", text = "Following")
    }
}

@Composable
fun ProfileStat(
    numberText: String,
    text: String,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        BoldText(
            text = numberText,
            fontSize = 15.sp
        )
        Spacer(modifier = Modifier.height(4.dp))
        BoldText(
            text = text,
            fontSize = 17.sp
        )
    }
}

@Composable
fun ProfileDescription(
    displayName: String,
    description: String,
    url: String,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    ) {
        TitleText(
            text = displayName,
        )
        BodyText(
            text = description,
        )
        BodyText(
            text = url,
            fontColor = Color(0xFF3D3D91),
            modifier = Modifier.clickable {
                // open link
            }
        )
        CustomAnnotatedText(
            textTypes = listOf<TextType>(
                TextType.TypeBody("Followed By "),
                TextType.TypeBold("Cristiano, "),
                TextType.TypeBold("RealMadrid, "),
                TextType.TypeBody("and "),
                TextType.TypeBold("17 others")
            )
        )
    }
}

@Composable
fun ButtonSection(
    modifier: Modifier = Modifier
) {
    val minWidth = 95.dp
    val height = 30.dp
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = modifier
    ) {
        ActionButton(
            text = "Following",
            icon = Icons.Default.KeyboardArrowDown,
            modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(height)
        )
        ActionButton(
            text = "Message",
            modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(height)
        )
        ActionButton(
            text = "Email",
            modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(height)
        )
        ActionButton(
            icon = Icons.Default.KeyboardArrowDown,
            modifier = Modifier
                .size(height)
        )
    }
}


@Composable
fun ActionButton(
    modifier: Modifier = Modifier,
    text: String? = null,
    icon: ImageVector? = null
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = RoundedCornerShape(5.dp)
            )
            .padding(6.dp)
    ) {
        if (text != null) {
            SemiBoldText(
                text = text,
                fontSize = 14.sp
            )
        }
        if (icon != null) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = Color.Black
            )
        }
    }
}

@Composable
fun HighlightSection(
    modifier: Modifier = Modifier,
    highlights: List<ImageWithText>
) {
    LazyRow(modifier = modifier) {
        items(highlights.size) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(end = 15.dp)
            ) {
                RoundedImage(
                    image = highlights[it].image,
                    modifier = Modifier.size(70.dp)
                )
                BodyText(
                    text = highlights[it].text,

                    )
            }
        }
    }
}

@Composable
fun PostTabView(
    modifier: Modifier = Modifier,
    imageWithTexts: List<ImageWithText>,
    onTabSelected: (selectedIndex: Int) -> Unit
) {
    var selectedTabIndex by remember {
        mutableStateOf(0)
    }
    val inactiveColor = Color(0xFF777777)
    TabRow(
        selectedTabIndex = selectedTabIndex,
        contentColor = Color.Black,
        modifier = modifier
    ) {
        imageWithTexts.forEachIndexed { index, item ->
            Tab(
                selected = selectedTabIndex == index,
                selectedContentColor = Color.Black,
                unselectedContentColor = inactiveColor,
                onClick = {
                    selectedTabIndex = index
                    onTabSelected(index)
                }
            ) {
                Icon(
                    painter = item.image,
                    contentDescription = item.text,
                    tint = if (selectedTabIndex == index) Color.Black else inactiveColor,
                    modifier = Modifier
                        .padding(10.dp)
                        .size(20.dp)
                )
            }
        }
    }
    @Composable
    fun PostTabView(
        modifier: Modifier = Modifier,
        imageWithTexts: List<ImageWithText>,
        onTabSelected: (selectedIndex: Int) -> Unit
    ) {
        var selectedTabIndex by remember {
            mutableStateOf(0)
        }
        val inactiveColor = Color(0xFF777777)
        TabRow(
            selectedTabIndex = selectedTabIndex,
            contentColor = Color.Black,
            modifier = modifier
        ) {
            imageWithTexts.forEachIndexed { index, item ->
                Tab(
                    selected = selectedTabIndex == index,
                    selectedContentColor = Color.Black,
                    unselectedContentColor = inactiveColor,
                    onClick = {
                        selectedTabIndex = index
                        onTabSelected(index)
                    }
                ) {
                    Icon(
                        painter = item.image,
                        contentDescription = item.text,
                        tint = if (selectedTabIndex == index) Color.Black else inactiveColor,
                        modifier = Modifier
                            .padding(10.dp)
                            .size(20.dp)
                    )
                }
            }
        }
    }
}

@ExperimentalFoundationApi
@Composable
fun PostSection(
    posts: List<Painter>,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        GridCells.Fixed(3),

        ) {
        items(posts.size) {
            Image(
                painter = posts[it],
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .aspectRatio(1f)
                    .border(
                        width = 1.dp,
                        color = Color.White
                    )
            )
        }
    }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
@Preview
fun preview() {
    InstagramScreen()
}