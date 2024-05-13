import { useNavigate } from "react-router-dom";
import { Button } from "@mantine/core";
import { IconHeartFilled, IconHeart } from "@tabler/icons-react";
import { fetchCreateLike, fetchDeleteLike, useIsLiked } from "../util/hooks";

function ButtonLike({ children, postId }) {
    const navigate = useNavigate();
    const [data, error] = useIsLiked(postId);

    const handleLikeButton = (event) => {
        event.preventDefault();
        if (data === true) {
            fetchDeleteLike(postId);
        } else {
            fetchCreateLike(postId);
        }
        navigate(0);
    }

    if (error || data == null) return null;
    return (
        <Button 
            variant="subtle"
            color={data ? "red" : "gray"}
            leftSection={
                data
                ?
                <IconHeartFilled size={20} />
                :
                <IconHeart size={20}/>
            }
            onClick={handleLikeButton}
        >
            {children}
        </Button>
    );
}

export default ButtonLike;