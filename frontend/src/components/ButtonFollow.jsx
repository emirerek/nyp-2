import { useNavigate } from "react-router-dom";
import { Button } from "@mantine/core";
import { IconUserPlus, IconRosetteDiscountCheck } from "@tabler/icons-react";
import { fetchCreateFollower, fetchDeleteFollower, useIsFollowing } from "../util/hooks";

function ButtonFollow({ followedUserId }) {
    const navigate = useNavigate();
    const [data, error] = useIsFollowing(followedUserId);

    const handleLikeButton = (event) => {
        event.preventDefault();
        if (data === true) {
            fetchDeleteFollower(followedUserId);
        } else {
            fetchCreateFollower(followedUserId);
        }
        navigate(0);
    }

    if (error || data == null) return null;
    return (
        followedUserId !== 1
        ?
        <Button 
            variant="filled"
            leftSection={
                data
                ?
                <IconRosetteDiscountCheck size={20} />
                :
                <IconUserPlus size={20}/>
            }
            onClick={handleLikeButton}
        >
            {
                data ? "Followed" : "Follow"
            }
        </Button>
        :
        null
    );
}

export default ButtonFollow;