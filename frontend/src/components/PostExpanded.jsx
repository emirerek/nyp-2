import { 
    Card, 
    CardContent,
    CardHeader,
    CardMedia, 
    Avatar, 
    Typography,
    Box,
    Divider
} from "@mui/material";

function PostExpanded({ post }) {
    return (
        <Card>
            <CardHeader 
                avatar={
                    <Avatar>EE</Avatar>
                }
                title={post.user.username}
                subheader={post.creationDate}
            />
            <CardContent>
                <Typography>
                    {post.textContent}
                </Typography>
            </CardContent>
            {
                post.imageUrl 
                ? 
                <CardMedia 
                    component="img"
                    image={post.imageUrl}
                    sx={{p: 2}}
                />
                :
                null
            }
        </Card>
    );
}

export default PostExpanded;