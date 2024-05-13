import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { Button, Textarea, Stack } from "@mantine/core";
import { fetchCreateComment } from "../util/hooks";

function CommentForm({ postId }) {
    const navigate = useNavigate(0);
    const [input, setInput] = useState("");
  
    const handleClick = (event) => {
        event.preventDefault();
        fetchCreateComment(postId, input);
        setInput("");
        navigate(0);
        close();
    };
  
    return (
        <Stack>
            <Textarea 
                label="Comment"
                placeholder="Write a comment"
                value={input}
                onChange={(event) => setInput(event.currentTarget.value)}
            />
            <Button onClick={handleClick}>
                Send
            </Button>
        </Stack>
    );
  };
  
  export default CommentForm;