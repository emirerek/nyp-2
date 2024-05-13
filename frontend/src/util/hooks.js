import { useState, useEffect } from "react";
import { useParams } from "react-router-dom";

const useFetch = (url, options = {}) => {
    const [data, setData] = useState(null);
    const [error, setError] = useState(null);
    const [loading, setLoading] = useState(false);
    useEffect(() => {
        let controller = new AbortController();
        let signal = controller.signal;
        (async () => {
            try {
                setLoading(true);
                const response = await fetch(url, {signal, ...options});
                const data = await response.json();
                if (!response.ok) {
                    setLoading(false);
                    throw new Error("Not OK");
                }
                setData(data);
                setLoading(false);
            } catch (error) {
                if (error.name !== "AbortError") {
                    setError(error.message);
                    setLoading(false);
                    console.error(error);
                } else {
                    setLoading(false);
                    console.error("Request aborted");
                }
            }
        })();
        return () => {controller.abort()};
    }, [url]);
    return [data, error, loading];
}

const usePosts = () => {
    const url = "http://localhost:8080/posts";
    return useFetch(url);
}

const useFollowedPosts = () => {
    const userId = 1;
    const url = "http://localhost:8080/posts/followed?userId=" + userId;
    return useFetch(url);
}

const usePost = () => {
    const { postId } = useParams();
    const url = "http://localhost:8080/posts/" + postId;
    return useFetch(url);
}

const usePostWithId = (postId) => {
    const url = "http://localhost:8080/posts/" + postId;
    return useFetch(url);
}

const usePostComments = () => {
    const { postId } = useParams();
    const url = "http://localhost:8080/comments?postId=" + postId;
    return useFetch(url);
}

const useUsers = () => {
    const url = "http://localhost:8080/users";
    return useFetch(url);
}

const useUser = () => {
    const { userId } = useParams();
    const url = "http://localhost:8080/users/" + userId;
    return useFetch(url);
}

const useUserPosts = () => {
    const { userId } = useParams();
    const url = "http://localhost:8080/posts?userId=" + userId;
    return useFetch(url);
}

const useUserLikes = () => {
    const { userId } = useParams();
    const url = "http://localhost:8080/likes?userId=" + userId;
    return useFetch(url);
}

const useUserComments = () => {
    const { userId } = useParams();
    const url = "http://localhost:8080/comments?userId=" + userId;
    return useFetch(url);
}

const useIsLiked = (postId) => {
    const userId = 1;
    const url = `http://localhost:8080/likes/${postId}?userId=1`;
    return useFetch(url);
}

const useIsFollowing = (followedUserId) => {
    const followingUserId = 1;
    const url = `http://localhost:8080/followers?followingUserId=${followingUserId}&followedUserId=${followedUserId}`;
    return useFetch(url);
}

const useFakeUser = () => {
    const url = "http://localhost:8080/users/1";
    return useFetch(url);
}

const fetchCreateLike = (postId) => {
    const userId = 1;
    const options = {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify({
            userId,
            postId
        })
    }
    const url = `http://localhost:8080/likes`;
    return fetch(url, options);
}

const fetchDeleteLike = (postId) => {
    const userId = 1;
    const options = {
        method: "DELETE",
        headers: {
            "Content-Type": "application/json",
        },
    }
    const url = `http://localhost:8080/likes?postId=${userId}&userId=${postId}`;
    return fetch(url, options);
}

const fetchCreateFollower = (followedUserId) => {
    const followingUserId = 1;
    const options = {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify({
            followingUserId,
            followedUserId
        })
    }
    const url = `http://localhost:8080/followers`;
    return fetch(url, options);
}

const fetchDeleteFollower = (followedUserId) => {
    const followingUserId = 1;
    const options = {
        method: "DELETE",
        headers: {
            "Content-Type": "application/json",
        },
    }
    const url = `http://localhost:8080/followers?followingUserId=${followingUserId}&followedUserId=${followedUserId}`;
    return fetch(url, options);
}

const fetchCreatePost = (textContent) => {
    const userId = 1;
    const body = {
        userId,
        textContent
    }
    const options = {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(body)
    }
    const url = `http://localhost:8080/posts`;
    return fetch(url, options);
}

const fetchUpdatePost = (textContent) => {
    const userId = 1;
    const body = {
        userId,
        textContent
    }
    const options = {
        method: "PUT",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(body)
    }
    const url = `http://localhost:8080/posts`;
    return fetch(url, options);
}

const fetchCreateComment = (postId, textContent) => {
    const userId = 1;
    const body = {
        userId,
        postId,
        textContent
    }
    const options = {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(body)
    }
    const url = `http://localhost:8080/comments`;
    return fetch(url, options);
}

const fetchUpdateComment = (textContent) => {
    const userId = 1;
    const body = {
        userId,
        postId,
        textContent
    }
    const options = {
        method: "PUT",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(body)
    }
    const url = `http://localhost:8080/comments`;
    return fetch(url, options);
}

export { 
    useFetch, 
    usePosts, 
    useFollowedPosts,
    usePost,
    usePostWithId,
    useUsers, 
    useUser, 
    useUserPosts, 
    usePostComments,
    useUserComments, 
    useUserLikes, 
    useIsLiked,
    useIsFollowing,
    useFakeUser,
    fetchCreateLike,
    fetchDeleteLike,
    fetchCreateFollower,
    fetchDeleteFollower,
    fetchCreatePost,
    fetchUpdatePost,
    fetchCreateComment
};